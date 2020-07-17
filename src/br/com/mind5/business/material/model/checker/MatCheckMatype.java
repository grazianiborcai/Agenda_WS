package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.checker.MatypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatCheckMatype extends ModelCheckerTemplateForwardV2<MatInfo, MatypeInfo> {
	
	public MatCheckMatype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatypeCheckExist(option);
	}
	
	
	
	@Override protected MatypeInfo toForwardClass(MatInfo baseRecord) {
		return MatypeInfo.copyFrom(baseRecord);
	}
}
