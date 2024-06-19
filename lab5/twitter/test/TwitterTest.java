import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

class TwitterTest {

    @Test
    void actual_call() {
        Twitter twitter = new Twitter();

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);
    }

    @Test
    void mock_full_object() {
        Twitter twitter = createMock("twitter", Twitter.class);

        expect(twitter.loadTweet()).andReturn("hello @me");
        expect(twitter.loadTweet()).andReturn("hello @you");
        replay(twitter);

        String actual;

        actual = twitter.loadTweet();
        assertEquals("hello @me", actual);

        actual = twitter.loadTweet();
        assertEquals("hello @you", actual);
    }

    @Test
    void mock_partial_object() {
        Twitter twitter = partialMockBuilder(Twitter.class)
          .addMockedMethod("loadTweet")
          .createMock();

        expect(twitter.loadTweet()).andReturn("hello @me").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);

        actual = twitter.isMentionned("you");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_lookForAtSymbol() {
        Twitter twitter = createMock(Twitter.class);

        expect(twitter.isMentionned("me")).andReturn(true);
        expect(twitter.isMentionned("you")).andReturn(false);

        replay(twitter);

        assertEquals(true, twitter.isMentionned("me"));
        assertEquals(false, twitter.isMentionned("you"));

        verify(twitter);
    }

    @Test
    void isMentionned_dontReturnSubstringMatches() {
        Twitter twitter = createMock(Twitter.class);

        expect(twitter.isMentionned("me")).andReturn(false);
        expect(twitter.isMentionned("meat")).andReturn(true);

        replay(twitter);

        assertEquals(false, twitter.isMentionned("me"));
        assertEquals(true, twitter.isMentionned("meat"));

        verify(twitter);
    }

    @Test
    void isMentionned_superStringNotFound() {
        Twitter twitter = createMock(Twitter.class);

        expect(twitter.isMentionned("me")).andReturn(true);
        expect(twitter.isMentionned("meat")).andReturn(false);

        replay(twitter);

        assertEquals(true, twitter.isMentionned("me"));
        assertEquals(false, twitter.isMentionned("meat"));

        verify(twitter);
    }

    @Test
    void isMentionned_handleNull() {
        Twitter twitter = createMock(Twitter.class);

        expect(twitter.isMentionned("me")).andReturn(false);
        expect(twitter.isMentionned("meat")).andReturn(false);

        replay(twitter);

        assertEquals(false, twitter.isMentionned("me"));
        assertEquals(false, twitter.isMentionned("meat"));

        verify(twitter);
    }
}