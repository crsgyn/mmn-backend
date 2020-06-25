package com.mmn.mail.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class MailAsyncTaskConfig {

    public static final String THREAD_POOL_TASK_EXECUTOR = "MailThreadPoolTaskExecutor";
    private static final String THREAD_NAME_PREFIX = "MailAsync-";

    @Bean(THREAD_POOL_TASK_EXECUTOR)
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        return executor;
    }
}
