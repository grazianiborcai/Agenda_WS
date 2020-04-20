package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMateg;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatGroup;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatype;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatunit;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatextsnap;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapMergeToSelect;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatsnapSelect extends DeciTreeTemplateReadV1<MatsnapInfo> {
	
	public RootMatsnapSelect(DeciTreeOption<MatsnapInfo> option) {
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
		checker = new MatsnapCheckRead(checkerOption);
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
		
		ActionStdV1<MatsnapInfo> select = new StdMatsnapMergeToSelect(option);
		ActionLazyV1<MatsnapInfo> mergeMatextsnap = new LazyMatsnapMergeMatextsnap(option.conn, option.schemaName);
		ActionLazyV1<MatsnapInfo> mergeMatype = new LazyMatsnapMergeMatype(option.conn, option.schemaName);
		ActionLazyV1<MatsnapInfo> mergeMateg = new LazyMatsnapMergeMateg(option.conn, option.schemaName);
		ActionLazyV1<MatsnapInfo> mergeMatGroup = new LazyMatsnapMergeMatGroup(option.conn, option.schemaName);
		ActionLazyV1<MatsnapInfo> mergeMatunit = new LazyMatsnapMergeMatunit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatunit);
		
		actions.add(select);
		return actions;
	}
}
