package br.com.mind5.security.userSearch.info;


import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.security.user.info.UserInfo;

public final class UserarchCopier {
	public static UserarchInfo copyFromSytotauh(SytotauhInfo source) {
		InfoCopier<UserarchInfo, SytotauhInfo> copier = new UserarchCopySytotauh();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromSytotauh(List<SytotauhInfo> sources) {
		InfoCopier<UserarchInfo, SytotauhInfo> copier = new UserarchCopySytotauh();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserarchInfo copyFromSchedauth(SchedauthInfo source) {
		InfoCopier<UserarchInfo, SchedauthInfo> copier = new UserarchCopySchedauth();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromSchedauth(List<SchedauthInfo> sources) {
		InfoCopier<UserarchInfo, SchedauthInfo> copier = new UserarchCopySchedauth();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserarchInfo copyFromRefupol(RefupolInfo source) {
		InfoCopier<UserarchInfo, RefupolInfo> copier = new UserarchCopyRefupol();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromRefupol(List<RefupolInfo> sources) {
		InfoCopier<UserarchInfo, RefupolInfo> copier = new UserarchCopyRefupol();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserarchInfo copyFromUser(UserInfo source) {
		InfoCopier<UserarchInfo, UserInfo> copier = new UserarchCopyUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromUser(List<UserInfo> sources) {
		InfoCopier<UserarchInfo, UserInfo> copier = new UserarchCopyUser();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserarchInfo copyFromRefem(RefemInfo source) {
		InfoCopier<UserarchInfo, RefemInfo> copier = new UserarchCopyRefem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromRefem(List<RefemInfo> sources) {
		InfoCopier<UserarchInfo, RefemInfo> copier = new UserarchCopyRefem();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserarchInfo copyFromPayord(PayordInfo source) {
		InfoCopier<UserarchInfo, PayordInfo> copier = new UserarchCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<UserarchInfo, PayordInfo> copier = new UserarchCopyPayord();
		return copier.makeCopy(sources);
	}
}
