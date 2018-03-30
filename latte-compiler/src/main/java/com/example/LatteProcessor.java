package com.example;

import com.google.auto.service.AutoService;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
public class LatteProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        final Set<String> types = new LinkedHashSet<>();
        Set<Class<? extends Annotation>> annotations = getSupportedAnnotations();
        for (Class<? extends Annotation> annotation : annotations) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        final LinkedHashSet<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        annotations.add(EntryGenerator.class);
        annotations.add(PayEntryGenerator.class);
        annotations.add(AppRegisterGenerator.class);
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment environment) {
        generateEntryCode(environment);
        generatePayEntryCode(environment);
        generateAppRegisterCode(environment);
        return true;
    }

    private void scan(RoundEnvironment env, Class<? extends Annotation> annotation, AnnotationValueVisitor visitor) {
        for (Element typeElement : env.getElementsAnnotatedWith(annotation)) {

            final List<? extends AnnotationMirror> mirrors = typeElement.getAnnotationMirrors();
            for (AnnotationMirror mirror : mirrors) {

                final Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues = mirror.getElementValues();
                for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : elementValues.entrySet()) {
                    entry.getValue().accept(visitor, null);
                }

            }
        }
    }

    private void generateEntryCode(RoundEnvironment env) {
        final WXVisitor visitor = new WXVisitor("");
        visitor.setFiler(processingEnv.getFiler());
        scan(env, EntryGenerator.class, visitor);
    }

    private void generatePayEntryCode(RoundEnvironment env) {
        final WXVisitor visitor = new WXVisitor("pay");
        visitor.setFiler(processingEnv.getFiler());
        scan(env, PayEntryGenerator.class, visitor);
    }

    private void generateAppRegisterCode(RoundEnvironment env) {
        final WXVisitor visitor = new WXVisitor("register");
        visitor.setFiler(processingEnv.getFiler());
        scan(env, AppRegisterGenerator.class, visitor);
    }

}
