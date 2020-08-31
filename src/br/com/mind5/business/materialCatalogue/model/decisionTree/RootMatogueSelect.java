package br.com.mind5.business.materialCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.materialCatalogue.model.action.LazyMatogueEnforceMatubup;
import br.com.mind5.business.materialCatalogue.model.action.StdMatogueMergeMatore;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckLangu;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckOwner;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckRead;
import br.com.mind5.business.materialCatalogue.model.checker.MatogueCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatogueSelect extends DeciTreeTemplateReadV2<MatogueInfo> {
	
	public RootMatogueSelect(DeciTreeOption<MatogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatogueInfo> buildCheckerHook(DeciTreeOption<MatogueInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelCheckerV1<MatogueInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatogueInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatogueCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatogueCheckStore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatogueInfo>> buildActionsOnPassedHook(DeciTreeOption<MatogueInfo> option) {
		List<ActionStdV1<MatogueInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatogueInfo> mergeMatore = new StdMatogueMergeMatore(option);
		ActionLazyV1<MatogueInfo> enforceMatubup = new LazyMatogueEnforceMatubup(option.conn, option.schemaName);
		
		mergeMatore.addPostAction(enforceMatubup);
		
		actions.add(mergeMatore);		
		return actions;
	}
}
