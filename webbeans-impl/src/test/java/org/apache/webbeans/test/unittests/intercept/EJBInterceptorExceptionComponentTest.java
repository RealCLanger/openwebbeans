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
package org.apache.webbeans.test.unittests.intercept;

import junit.framework.Assert;

import org.apache.webbeans.exception.WebBeansConfigurationException;
import org.apache.webbeans.test.AbstractUnitTest;
import org.apache.webbeans.test.component.intercept.MultpleInterceptor;
import org.junit.Test;

public class EJBInterceptorExceptionComponentTest extends AbstractUnitTest
{


    @Test
    public void testComponentTypeException()
    {
        try
        {
            startContainer(MultpleInterceptor.class);

        }
        catch (WebBeansConfigurationException e)
        {
            System.out.println("got expected exception: " + e.getMessage());
            return; // all ok!
        }
        Assert.fail("expecting an exception!");
        shutDownContainer();
    }

}
