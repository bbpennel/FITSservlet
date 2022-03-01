//
// Copyright (c) 2016 by The President and Fellows of Harvard College
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License. You may obtain a copy of the License at:
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is
// distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permission and limitations under the License.
//

package edu.harvard.hul.ois.fits.service.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FitsWrapperFactory extends BasePooledObjectFactory<FitsWrapper> {

    private static final Logger logger = LoggerFactory.getLogger(FitsWrapperFactory.class);

    @Override
    public FitsWrapper create() throws Exception {
        logger.debug("Creating new FitsWrapper instance in pool");
        return new FitsWrapper();
    }

    @Override
    public PooledObject<FitsWrapper> wrap(FitsWrapper fitsWrapper){
        return new DefaultPooledObject<FitsWrapper>(fitsWrapper);
    }

    @Override
    public boolean validateObject(PooledObject<FitsWrapper> fitsWrapper){
        return fitsWrapper.getObject().isValid();
    }


}
