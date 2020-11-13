package br.com.mind5.business.companySnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.action.StdCompnapDaoInsert;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckComp;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckOwner;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckWrite;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCompnapInsert extends DeciTreeTemplateWriteV2<CompnapInfo> {
	
	public RootCompnapInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CompnapInfo> buildCheckerHook(DeciTreeOption<CompnapInfo> option) {
		List<ModelCheckerV1<CompnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CompnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CompnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CompnapCheckComp(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CompnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CompnapInfo> option) {
		List<ActionStdV2<CompnapInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CompnapInfo> insert = new StdCompnapDaoInsert(option);
		
		actions.add(insert);
		return actions;
	}
}
