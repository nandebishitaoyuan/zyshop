package icu.javacg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@TableName("commodity")
public class Commodity {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    private String gname;
    private Double gprice;
    private String gclass;
    private Integer gamount;
    private String gdate;
    private String gimgurl;
    private Integer glook;
    private String gintro;
    private String gbrief;
}
