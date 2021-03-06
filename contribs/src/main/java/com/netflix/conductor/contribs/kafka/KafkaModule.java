package com.netflix.conductor.contribs.kafka;

import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.ProvidesIntoMap;
import com.google.inject.multibindings.StringMapKey;
import com.google.inject.name.Named;
import com.netflix.conductor.core.config.Configuration;
import com.netflix.conductor.core.events.EventQueueProvider;

/**
 * KafkaModule is a class for application of dependency injection for Kafka
 *
 * @author Glia Ecosystems
 */

public class KafkaModule extends AbstractModule {
    private static final Logger logger = LoggerFactory.getLogger(KafkaModule.class);

    @Override
    protected void configure() {
        logger.info("Kafka module configured.");
    }

    @ProvidesIntoMap
    @StringMapKey("kafka")
    @Singleton
    @Named("EventQueueProviders")
    public EventQueueProvider getKafkaEventQueueProvider(final Configuration configuration, final Injector injector) {
        return new KafkaEventQueueProvider(configuration, injector);
    }

}