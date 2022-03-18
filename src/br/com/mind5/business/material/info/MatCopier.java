package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoCopier;

public final class MatCopier {
	public static List<MatInfo> copyFromOrdemrap(List<OrdemrapInfo> sources) {
		InfoCopier<MatInfo, OrdemrapInfo> copier = new MatCopyOrdemrap();
		return copier.makeCopy(sources);
	}
}
