package org.ff4j.event;

import java.util.Optional;

/*
 * #%L
 * ff4j-core
 * %%
 * Copyright (C) 2013 - 2016 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.TreeSet;

import org.ff4j.event.monitoring.HitCount;

/**
 * Proposal of data structure to store a set of events.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class EventSeries extends TreeSet < Event > {
    
    /** Serial */
    private static final long serialVersionUID = 7093204704994389688L;
    
    /** Capacity -1 is infinite - Cause OutOfMemory. */
    private long capacity = -1;
    
    /**
     * Default constructor.
     *
     * @param capacity
     *      capacity
     */
    public EventSeries() {
       this.capacity = 100000;
    }
    
    /**
     * Compute average iteself.
     *
     * @return
     */
    public double getAverageDuration() {
        HitCount total = new HitCount();
        HitCount size  = new HitCount();
        this.stream()
            .map(Event::getDuration)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(Long::intValue)
            .peek(val -> size.inc())
            .forEach(total::incBy);
        return total.get() / size.get();
    }

    /**
     * Default constructor.
     *
     * @param capacity
     *      capacity
     */
    public EventSeries(final long capacity) {
        super();
        this.capacity = capacity;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean add(final Event e) {
        if (capacity > 0 && size() >= capacity) {
            return false;
        }
        return super.add(e);
    }
    
    public boolean contains(String eventUid) {
        return getById(eventUid).isPresent();
    }
    
    public Optional < Event > getById(String eventUid) {
        return this.stream()
                .filter(evt -> evt.getUid().equals(eventUid))
                .findFirst();
    }

}
