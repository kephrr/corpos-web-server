package corpos.dakar.web_server.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeleteResults {
    Deleted_Successfully(1),
    Already_Deleted(0);
    private final Integer index;
}
