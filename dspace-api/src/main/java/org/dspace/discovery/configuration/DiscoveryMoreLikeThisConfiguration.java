/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.discovery.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class that contains the more like this configuration on item pages
 *
 * @author Kevin Van de Velde (kevin at atmire dot com)
 * @author Ben Bosman (ben at atmire dot com)
 * @author Mark Diggory (markd at atmire dot com)
 */
public class DiscoveryMoreLikeThisConfiguration {
    private final List<String> similarityMetadataFields;
    private final int minTermFrequency;
    private final int max;
    private int minWordLength;

    /**
     * Initialize a configuration with require fields.
     * @param similarityMetadataFields metadata fields to check for similarity
     * @param minTermFrequency The minimum number of matching terms across the metadata fields above
     *                         before an item is found as related
     * @param max The maximum number of related items displayed
     */
    @Autowired
    public DiscoveryMoreLikeThisConfiguration(List<String> similarityMetadataFields, int minTermFrequency,
                                              int max) {
        this.similarityMetadataFields = similarityMetadataFields;
        this.minTermFrequency = minTermFrequency;
        this.max = max;
    }

    public List<String> getSimilarityMetadataFields() {
        return similarityMetadataFields;
    }

    public int getMinTermFrequency() {
        return minTermFrequency;
    }

    public int getMax() {
        return max;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    /**
     * Set the minimum word length below which words will be ignored
     * @param minWordLength
     */
    public void setMinWordLength(int minWordLength) {
        this.minWordLength = minWordLength;
    }
}
