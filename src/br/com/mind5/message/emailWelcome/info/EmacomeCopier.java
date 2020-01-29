package br.com.mind5.message.emailWelcome.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class EmacomeCopier {	
	public static EmacomeInfo copyFromUpswd(UpswdInfo source) {
		InfoCopier<EmacomeInfo, UpswdInfo> copier = new EmacomeCopyUpswd();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmacomeInfo> copyFromUpswd(List<UpswdInfo> sources) {
		InfoCopier<EmacomeInfo, UpswdInfo> copier = new EmacomeCopyUpswd();
		return copier.makeCopy(sources);
	}
}
