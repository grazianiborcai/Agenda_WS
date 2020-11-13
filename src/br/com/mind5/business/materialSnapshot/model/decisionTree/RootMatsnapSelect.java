package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMateg;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatextsnap;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatoup;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatubup;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatunit;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMergeMatype;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapMergeToSelect;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatsnapSelect extends DeciTreeTemplateReadV2<MatsnapInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV2<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStdV2<MatsnapInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatsnapInfo> select = new StdMatsnapMergeToSelect(option);
		ActionLazy<MatsnapInfo> mergeMatextsnap = new LazyMatsnapMergeMatextsnap(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatype = new LazyMatsnapMergeMatype(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMateg = new LazyMatsnapMergeMateg(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatoup = new LazyMatsnapMergeMatoup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatubup = new LazyMatsnapMergeMatubup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatunit = new LazyMatsnapMergeMatunit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatype);
		mergeMatype.addPostAction(mergeMateg);
		mergeMateg.addPostAction(mergeMatoup);
		mergeMatoup.addPostAction(mergeMatubup);
		mergeMatubup.addPostAction(mergeMatunit);
		
		actions.add(select);
		return actions;
	}
}
