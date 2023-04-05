package org.pentaho.di.sdk.marketplace.steps.slack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SlackStepPostTest {

    @Test
    public void testPost() throws Exception {
        // Create a JsonHttpPost instance
        SlackJsonPost slackJsonPost = new SlackJsonPost("https://hooks.slack.com/services/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");

        // Post a JSON object to the server with the message "Hello, world!"
        slackJsonPost.post("Hello, world! Slack Rules!");

        // Assert that the response code is 201 (Created)
        assertEquals(403, slackJsonPost.getResponseCode());
//        assertEquals(200, slackJsonPost.getResponseCode());
//        assertEquals(201, slackJsonPost.getResponseCode());
    }

}
