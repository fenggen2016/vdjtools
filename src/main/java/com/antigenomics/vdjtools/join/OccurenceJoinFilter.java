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
 * Last modified on 25.10.2014 by mikesh
 */

package com.antigenomics.vdjtools.join;

public class OccurenceJoinFilter implements JoinFilter {
    private final int occurenceThreshold;

    public OccurenceJoinFilter() {
        this(2);
    }

    public OccurenceJoinFilter(int occurenceThreshold) {
        this.occurenceThreshold = occurenceThreshold;
    }

    public int getOccurenceThreshold() {
        return occurenceThreshold;
    }

    @Override
    public boolean pass(JointClonotype jointClonotype) {
        int detectionCounter = 0;
        for (int i = 0; i < jointClonotype.getParent().getNumberOfSamples(); i++) {
            if (jointClonotype.present(i) && ++detectionCounter == occurenceThreshold) return true;
        }
        return false;
    }
}