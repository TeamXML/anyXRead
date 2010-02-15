/*
 * Copyright 2008-2010 Digital Enterprise Research Institute (DERI)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deri.any23.extractor.example;

import org.deri.any23.extractor.ExtractionException;
import org.deri.any23.extractor.ExtractionResult;
import org.deri.any23.extractor.Extractor.BlindExtractor;
import org.deri.any23.extractor.ExtractorDescription;
import org.deri.any23.extractor.ExtractorFactory;
import org.deri.any23.extractor.SimpleExtractorFactory;
import org.deri.any23.rdf.PopularPrefixes;
import org.deri.any23.vocab.FOAF;
import org.openrdf.model.URI;
import org.openrdf.model.vocabulary.RDF;

import java.io.IOException;
import java.util.Collections;

/**
 * Example concrete implementation of {@link org.deri.any23.extractor.Extractor.BlindExtractor}.
 */
public class ExampleExtractor implements BlindExtractor {

    public void run(URI in, URI documentURI, ExtractionResult out)
            throws IOException, ExtractionException {
        out.writeTriple(documentURI, RDF.TYPE, FOAF.Document);
    }

    public ExtractorDescription getDescription() {
        return factory;
    }

    public static final ExtractorFactory<ExampleExtractor> factory =
            SimpleExtractorFactory.create(
                    "example",
                    PopularPrefixes.createSubset("rdf", "foaf"),
                    Collections.singleton("*/*;q=0.01"),
                    "http://example.com/",
                    ExampleExtractor.class
            );
}