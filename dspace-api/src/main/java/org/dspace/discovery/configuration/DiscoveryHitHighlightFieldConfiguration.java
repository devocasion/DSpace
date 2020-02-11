/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.discovery.configuration;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Configuration class that holds hit highlighting configuration for a single metadata field
 *
 * @author Kevin Van de Velde (kevin at atmire dot com)
 * @author Ben Bosman (ben at atmire dot com)
 * @author Mark Diggory (markd at atmire dot com)
 */
public class DiscoveryHitHighlightFieldConfiguration {
    private final String field;
    private int maxSize = 0;
    private int snippets = 3;


    /**
     * Initialize configuration for a specific metadata field
     * @param field metadata field for which this configuration is used
     */
    @Autowired
    public DiscoveryHitHighlightFieldConfiguration(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Set the maximum number of highlighted snippets to generate per field
     *
     * @param snippets the number of maximum snippets
     */
    public void setSnippets(int snippets) {
        this.snippets = snippets;
    }

    /**
     * Get the maximum number of highlighted snippets to generate per field
     *
     * @return maximum number of highlighted snippets to generate per field
     */
    public int getSnippets() {
        return snippets;
    }
}
