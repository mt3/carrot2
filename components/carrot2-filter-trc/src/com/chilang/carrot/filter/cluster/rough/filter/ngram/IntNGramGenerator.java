/**
 * 
 * @author chilang
 * Created 2003-08-23, 15:46:35.
 */
package com.chilang.carrot.filter.cluster.rough.filter.ngram;

import java.util.ArrayList;
import java.util.Collection;

public class IntNGramGenerator {

    protected int delimiterCode;
    protected int maxLength;

    public IntNGramGenerator(int maxLength, int delimiterCode) {
        this.maxLength = maxLength;
        this.delimiterCode = delimiterCode;
    }

     public IntNGram[] generate(int[] tokens) {
        Collection ngrams = new ArrayList();

        /**
         * Last longest phrase (list of words) in the processing token stream
         */
        int head=0, tail=0;

        for(int i=0; i <tokens.length; i++) {

            if (tokens[i] == delimiterCode) {

                //reset phrase buffer
                head = i;
                tail = head;

            } else {

                // add new word to phrase buffer
                tail++;

                /**
                 * Generate ngram of length from 1 .. min(maxLength, phrase buffer size)
                 * starting from last word, extending backward
                 */
                int bufferLength = tail - head;
                for (int k=1; k<=maxLength && k<=bufferLength; k++) {
                    ngrams.add(new IntNGram(tokens, i-k+1, k));
                }
            }
        }

        return (IntNGram[])ngrams.toArray(new IntNGram[ngrams.size()]);

    }
}
