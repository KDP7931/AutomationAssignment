package com.qa.Base;

import java.time.Duration;

public interface AutoConstant {
	
	public static final Duration ExplicitWaitTime = Duration.ofSeconds(30);
	long ImplicitWaitTime = 90;
	Duration PageLoaderTime = Duration.ofSeconds(30);

}
