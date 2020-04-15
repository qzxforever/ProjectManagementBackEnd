package org.bestsoft.DTO.response;

import lombok.Data;
import org.bestsoft.DTO.InoutcomeDTO;
import org.bestsoft.DTO.ServiceJobDTO;
import org.bestsoft.DTO.UserQueryDTO;
import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.entity.Project;
import org.bestsoft.jpa.entity.ProjectJob;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ProjectInfoResponse {
    private Project project;
    private List<InoutcomeDTO> inoutcomeDTOList;
    private List<ServiceJobDTO> serviceJobList;

    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ProjectInfoResponse(Project project, List<Inoutcome> inoutcomeList, List<ProjectJob> projectJobList) {
        this.project = project;
        this.inoutcomeDTOList = inoutcomeList.stream()
                .map(inoutcome ->
                        InoutcomeDTO.builder()
                                .amount(inoutcome.getAmount())
                                .balance(inoutcome.getBalance())
                                .ownAccount(inoutcome.getOwnAccount())
                                .otherAccount(inoutcome.getOtherAccount())
                                .cardType(inoutcome.getCardType())
                                .transactionDate(sdf.format(Optional.ofNullable(inoutcome.getTransactionDate()).orElse(new Timestamp(System.currentTimeMillis()))))
                                .unit(inoutcome.getUnit())
                                .type(inoutcome.getType())
                                .build()
                ).collect(Collectors.toList());

        this.serviceJobList = projectJobList.stream()
                .map(serviceJob ->
                        ServiceJobDTO.builder()
                                .cdate(sdf.format(serviceJob.getCdate()))
                                .edate(sdf.format(serviceJob.getEdate()))
                                .confirmUser(serviceJob.getConfirmerUser().getName())
                                .executeUser(serviceJob.getExecutorUser().getName())
                                .remark(serviceJob.getRemark())
                                .build()
                ).collect(Collectors.toList());
    }
}
