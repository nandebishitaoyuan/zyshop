package icu.javacg.pojo;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("orderGoods")
public class OrderGoods {
    @TableId(type = IdType.AUTO)
    private Integer ogid;
    private Integer oid;
    private Integer uid;
    private Integer gid;
    private Integer ogamount;
    private Double ogtotalprice;
    @TableField(exist = false)
    private Commodity commodity;
}
