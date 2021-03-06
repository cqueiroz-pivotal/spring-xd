/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.dirt.plugins.stream;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;

/**
 * A custom converter for {@link MediaType} that accepts a plain java class name as a shorthand for
 * {@code application/x-java-object;type=the.qualified.ClassName}.
 * 
 * 
 * @author Eric Bottard
 */
public class CustomMediaTypeConverter implements Converter<String, MediaType> {

	@Override
	public MediaType convert(String source) {
		if (!source.contains("/")) {
			return MediaType.valueOf("application/x-java-object;type=" + source);
		}
		return MediaType.valueOf(source);
	}

}
