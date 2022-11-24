package icu.javacg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer oid;
    private String odate;
    private Integer aid;
    private String ostate;
    private String orecname;
    private String orecadr;
    private String orectel;
    private Integer uid;
    private Double ototalprice;
}
