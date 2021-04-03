package MVCDemo.Controller;

import javax.servlet.http.*;

public class SessionCounter implements HttpSessionListener
{
	private static int sessionCount = 0;

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent)
	{
		sessionCount++;
		System.out.println("\nSession "+ sessionCount+" created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent)
	{
		sessionCount--;
	}

	public static int getSessionCount()
	{
		return sessionCount;
	}

}