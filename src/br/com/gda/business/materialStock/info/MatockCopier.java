package br.com.gda.business.materialStock.info;

import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.info.InfoCopier;

public final class MatockCopier {
	public static MatockInfo copyFromMatmov(MatmovInfo source) {
		InfoCopier<MatockInfo, MatmovInfo> copier = new MatockCopyMatmov();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<MatockInfo> copyFromMatmov(List<MatmovInfo> sources) {
		InfoCopier<MatockInfo, MatmovInfo> copier = new MatockCopyMatmov();
		return copier.makeCopy(sources);
	}
}
