/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.rdf.factory;

import org.apache.logging.log4j.Logger;
import org.dspace.rdf.conversion.RDFConverter;
import org.dspace.rdf.storage.RDFStorage;
import org.dspace.rdf.storage.URIGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Pascal-Nicolas Becker (p dot becker at tu hyphen berlin dot de)
 */
public class RDFFactoryImpl extends RDFFactory {
    // we have several URIGenerators that use each other as fallback
    // following we have to instantiate all of them and cannot use autowiring
    // by type here. So we use setters and properties in Spring configuration
    // instead.

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(RDFFactoryImpl.class);

    private final RDFStorage storage;
    private final URIGenerator generator;
    private final RDFConverter converter;

    /**
     * Initialize a new RDFFactory implementation with given required settings
     * @param storage RDFStorage to use
     * @param generator URIGenerator to use
     * @param converter RDFConverter to use
     */
    @Autowired
    public RDFFactoryImpl(RDFStorage storage, URIGenerator generator, RDFConverter converter) {
        this.storage = storage;

        if (log.isDebugEnabled()) {
            log.debug("Using '" + generator.getClass().getCanonicalName()
                          + "' as URIGenerator.");
        }
        this.generator = generator;

        this.converter = converter;
    }

    @Override
    public RDFStorage getRDFStorage() {
        return storage;
    }

    @Override
    public URIGenerator getURIGenerator() {
        return generator;
    }

    @Override
    public RDFConverter getRDFConverter() {
        return converter;
    }

}
