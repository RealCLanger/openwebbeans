/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.test.unittests.exception;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.Bean;

import junit.framework.Assert;

import org.apache.webbeans.exception.WebBeansConfigurationException;
import org.apache.webbeans.test.AbstractUnitTest;
import org.apache.webbeans.test.component.exception.stero.ComponentDefaultScopeWithDifferentScopeSteros;
import org.apache.webbeans.test.component.exception.stero.ComponentDefaultScopeWithNonScopeStero;
import org.apache.webbeans.test.component.exception.stero.ComponentNonDefaultScopeWithDifferentScopeSteros;
import org.apache.webbeans.test.component.exception.stero.ComponentWithDefaultScopeStero;
import org.apache.webbeans.test.component.exception.stero.ComponentWithDifferentScopeSteros;
import org.apache.webbeans.test.component.exception.stero.ComponentWithNonScopeStero;
import org.apache.webbeans.test.component.exception.stero.ComponentWithSameScopeSteros;
import org.apache.webbeans.test.component.exception.stero.ComponentWithoutScopeStero;
import org.junit.Test;

public class ScopeTypeExceptionComponentTest extends AbstractUnitTest
{
    @Test
    public void testComponentWithNonScopeStero()
    {
        startContainer(ComponentWithNonScopeStero.class);
        Bean<?> bean = getBean(ComponentWithNonScopeStero.class);

        Assert.assertEquals(Dependent.class, bean.getScope());
    }

    @Test
    public void testComponentDefaultScopeWithNonScopeStero()
    {
        startContainer(ComponentDefaultScopeWithNonScopeStero.class);
        Bean<?> bean = getBean(ComponentDefaultScopeWithNonScopeStero.class);

        Assert.assertEquals(SessionScoped.class, bean.getScope());
    }

    @Test
    public void testComponentWithDefaultScopeStero()
    {
        startContainer(ComponentWithDefaultScopeStero.class);
        Bean<?> bean = getBean(ComponentWithDefaultScopeStero.class);

        Assert.assertEquals(RequestScoped.class, bean.getScope());
    }

    @Test(expected = WebBeansConfigurationException.class)
    public void testComponentWithDifferentScopeSteros()
    {
        startContainer(ComponentWithDifferentScopeSteros.class);
    }

    @Test
    public void testComponentWithoutScopeStero()
    {
        startContainer(ComponentWithoutScopeStero.class);
        Bean<?> bean = getBean(ComponentWithoutScopeStero.class);

        Assert.assertEquals(Dependent.class, bean.getScope());
    }

    @Test
    public void testComponentWithSameScopeSteros()
    {
        startContainer(ComponentWithSameScopeSteros.class);
        Bean<?> bean = getBean(ComponentWithSameScopeSteros.class);

        Assert.assertEquals(SessionScoped.class, bean.getScope());
    }

    @Test
    public void testComponentDefaultScopeWithDifferentScopeSteros()
    {
        startContainer(ComponentDefaultScopeWithDifferentScopeSteros.class);
        Bean<?> bean = getBean(ComponentDefaultScopeWithDifferentScopeSteros.class);

        Assert.assertEquals(SessionScoped.class, bean.getScope());
    }

    @Test(expected = WebBeansConfigurationException.class)
    public void testComponentNonDefaultScopeWithDifferentScopeSteros()
    {
        startContainer(ComponentNonDefaultScopeWithDifferentScopeSteros.class);
    }

}
