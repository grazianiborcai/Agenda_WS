package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckDelete;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootMatDelete extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public RootMatDelete(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatCheckExist(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV2<MatInfo>> actions = new ArrayList<>();
		//TODO: Eliminar do carrinho de compras
		ActionStdV2<MatInfo> nodeL1 = new NodeMatDeleteL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
