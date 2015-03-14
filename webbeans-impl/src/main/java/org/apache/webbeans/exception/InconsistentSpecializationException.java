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
package org.apache.webbeans.exception;

import javax.enterprise.inject.spi.DefinitionException;
import org.apache.webbeans.exception.helper.DescriptiveException;
import org.apache.webbeans.exception.helper.ExceptionMessageBuilder;

import java.io.ObjectStreamException;

public class InconsistentSpecializationException extends DefinitionException implements DescriptiveException
{
    private static final long serialVersionUID = 5398575103682514128L;

    private ExceptionMessageBuilder msg = new ExceptionMessageBuilder();

    public InconsistentSpecializationException(String message)
    {
        super(message);
    }

    public InconsistentSpecializationException(Throwable e)
    {
        super(e);
    }

    public InconsistentSpecializationException(String message, Throwable e)
    {
        super(message, e);
    }

    @Override
    public void addInformation(String additionalInformation)
    {
        msg.addInformation(additionalInformation);
    }

    @Override
    public String getMessage()
    {
        return msg.getAdditionalInformation(super.getMessage());
    }

    @Override
    public String getLocalizedMessage()
    {
        return msg.getAdditionalInformation(super.getLocalizedMessage());
    }

    private Object writeReplace() throws ObjectStreamException
    {
        return new DefinitionException(getMessage(), getCause());
    }
}
