package com.mmn.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AccountAsyncTaskConfig {

    public static final String THREAD_POOL_TASK_EXECUTOR = "AccountThreadPoolTaskExecutor";
    private static final String THREAD_NAME_PREFIX = "AccountAsync-";

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
