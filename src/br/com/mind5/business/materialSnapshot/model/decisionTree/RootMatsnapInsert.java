package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMatextsnapInsert;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapRootSelect;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapDaoInsert;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootMatsnapInsert extends DeciTreeTemplateWriteV2<MatsnapInfo> {
	
	public RootMatsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatsnapInfo> buildCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		List<ModelCheckerV1<MatsnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatsnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatsnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStdV1<MatsnapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<MatsnapInfo> insertMatsnap = new StdMatsnapDaoInsert(option);
		ActionLazyV1<MatsnapInfo> insertMatextsnap = new LazyMatsnapMatextsnapInsert(option.conn, option.schemaName);	
		ActionLazyV1<MatsnapInfo> select = new LazyMatsnapRootSelect(option.conn, option.schemaName);	
		
		insertMatsnap.addPostAction(insertMatextsnap);
		insertMatextsnap.addPostAction(select);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
