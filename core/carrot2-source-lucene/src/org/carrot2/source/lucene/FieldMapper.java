package org.carrot2.source.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Query;

public interface FieldMapper
{
    /**
     * Return the names of search fields in the index.
     */
    public String [] getSearchFields();

    /**
     * Map Lucene index's fields onto Carrot2 {@link org.carrot2.core.Document} instance.
     * It is sensible to map at least {@link org.carrot2.core.Document#CONTENT_URL},
     * {@link org.carrot2.core.Document#TITLE} and
     * {@link org.carrot2.core.Document#SUMMARY}.
     * 
     * @param luceneQuery {@link Query} used to fetch Lucene document from the index. It
     *            is advised to cache any query-related data internally and if this
     *            parameter does not change, reuse that data.
     * @param analyzer {@link Analyzer} used for creating the index.
     * @param luceneDoc Lucene hit.
     * @param doc Target Carrot2 document.
     */
    void map(Query luceneQuery, Analyzer analyzer, Document luceneDoc, org.carrot2.core.Document doc);
}
