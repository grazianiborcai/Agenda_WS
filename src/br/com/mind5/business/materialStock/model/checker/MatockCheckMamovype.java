package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatockCheckMamovype extends ModelCheckerTemplateForwardV2<MatockInfo, MamovypeInfo> {
	
	public MatockCheckMamovype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MamovypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new MamovypeCheckExist(option);
	}
	
	
	
	@Override protected MamovypeInfo toForwardClass(MatockInfo baseRecord) {
		return MamovypeInfo.copyFrom(baseRecord);
	}
}
