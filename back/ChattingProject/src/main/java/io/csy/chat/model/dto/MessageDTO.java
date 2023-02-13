package io.csy.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageDTO {
	
    private String author;
    private String contents;
    private String timestamp;
    
    
    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", content='" + contents + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
    
}
