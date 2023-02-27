package nttdata.bootcamp.redis.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletRedis {

    public String idWallet;

    public String approvalCode;
    public Date expirationDate;
}