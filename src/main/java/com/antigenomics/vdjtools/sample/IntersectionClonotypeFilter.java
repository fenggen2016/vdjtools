/*
 * Copyright 2013-2014 Mikhail Shugay (mikhail.shugay@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified on 26.10.2014 by mikesh
 */

package com.antigenomics.vdjtools.sample;

import com.antigenomics.vdjtools.Clonotype;
import com.antigenomics.vdjtools.intersection.IntersectionType;
import com.antigenomics.vdjtools.join.ClonotypeKeyGen;
import com.antigenomics.vdjtools.join.key.ClonotypeKey;

import java.util.Set;

public class IntersectionClonotypeFilter extends ClonotypeFilter {
    private final ClonotypeKeyGen clonotypeKeyGen;
    private final Set<ClonotypeKey> keySet;
    private final boolean negative;

    public IntersectionClonotypeFilter(IntersectionType intersectionType, Sample sample, boolean negative) {
        this.clonotypeKeyGen = new ClonotypeKeyGen(intersectionType);
        this.keySet = new ClonotypeKeyGen(intersectionType).generateKeySet(sample);
        this.negative = negative;
    }

    @Override
    protected boolean checkPass(Clonotype clonotype) {
        return negative ^ keySet.contains(clonotypeKeyGen.generateKey(clonotype));
    }
}