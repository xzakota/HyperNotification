package com.xzakota;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;

public class BaseTestCallback implements InvocationInterceptor {
    @Override
    public void interceptTestMethod(
        Invocation<@Nullable Void> invocation,
        ReflectiveInvocationContext<Method> invocationContext,
        ExtensionContext extensionContext
    ) {
        String className = extensionContext.getRequiredTestClass().getSimpleName();
        String methodName = invocationContext.getExecutable().getName();

        Timer.measure(String.format("%s.%s", className, methodName), () -> {
            try {
                invocation.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }
}
