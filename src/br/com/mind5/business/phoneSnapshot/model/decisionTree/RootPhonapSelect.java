package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.LazyPhonapMergeCountrone;
import br.com.mind5.business.phoneSnapshot.model.action.LazyPhonapMergeFormone;
import br.com.mind5.business.phoneSnapshot.model.action.StdPhonapMergeToSelect;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckLangu;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckOwner;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPhonapSelect extends DeciTreeTemplateReadV2<PhonapInfo> {

	public RootPhonapSelect(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PhonapInfo> buildCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelCheckerV1<PhonapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonapCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV1<PhonapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhonapInfo> mergeToSelect = new StdPhonapMergeToSelect(option);	
		ActionLazy<PhonapInfo> mergeCountrone = new LazyPhonapMergeCountrone(option.conn, option.schemaName);
		ActionLazy<PhonapInfo> mergeFormone = new LazyPhonapMergeFormone(option.conn, option.schemaName);

		mergeToSelect.addPostAction(mergeCountrone);	
		mergeCountrone.addPostAction(mergeFormone);
		
		actions.add(mergeToSelect);
		
		return actions;
	}
}
