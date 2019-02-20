package schultz.dustin.io.health;

import com.justgifit.JustGifItProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class JustGifItHealthIndicator implements HealthIndicator {

    @Inject
    private JustGifItProperties justGifItProperties;

    @Override
    public Health health() {
        if(!justGifItProperties.getGifLocation().canWrite()){
            return Health.down().build();
        }
        return Health.up().build();
    }
}
