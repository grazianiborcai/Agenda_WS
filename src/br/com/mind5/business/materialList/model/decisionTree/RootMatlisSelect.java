package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeFimist;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMateg;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatoup;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatype;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatunit;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatext;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeToSelect;
import br.com.mind5.business.materialList.model.checker.MatlisCheckLangu;
import br.com.mind5.business.materialList.model.checker.MatlisCheckOwner;
import br.com.mind5.business.materialList.model.checker.MatlisCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootMatlisSelect extends DeciTreeTemplateReadV1<MatlisInfo> {
	
	public RootMatlisSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelCheckerV1<MatlisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStdV1<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatlisInfo> select = new StdMatlisMergeToSelect(option);
		ActionLazyV1<MatlisInfo> mergeMatype = new LazyMatlisMergeMatype(option.conn, option.schemaName);
		ActionLazyV1<MatlisInfo> mergeMateg = new LazyMatlisMergeMateg(option.conn, option.schemaName);
		ActionLazyV1<MatlisInfo> mergeMatoup = new LazyMatlisMergeMatoup(option.conn, option.schemaName);
		ActionLazyV1<MatlisInfo> mergeMatunit = new LazyMatlisMergeMatunit(option.conn, option.schemaName);
		ActionLazyV1<MatlisInfo> mergeMatext = new LazyMatlisMergeMatext(option.conn, option.schemaName);
		ActionLazyV1<MatlisInfo> mergeFimist = new LazyMatlisMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatunit);
		mergeMatunit.addPostAction(mergeMatext);
		mergeMatext.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
