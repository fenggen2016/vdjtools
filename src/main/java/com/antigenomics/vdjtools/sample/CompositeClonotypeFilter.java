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
 * Last modified on 17.10.2014 by mikesh
 */

package com.antigenomics.vdjtools.sample;

import com.antigenomics.vdjtools.Clonotype;

import java.util.Collection;

public class CompositeClonotypeFilter extends ClonotypeFilter {
    private final Collection<ClonotypeFilter> filters;


    public CompositeClonotypeFilter(Collection<ClonotypeFilter> filters) {
        this.filters = filters;
    }

    @Override
    protected boolean checkPass(Clonotype clonotype) {
        for (ClonotypeFilter filter : filters)
            if (!filter.pass(clonotype))
                return false;

        return true;
    }
}