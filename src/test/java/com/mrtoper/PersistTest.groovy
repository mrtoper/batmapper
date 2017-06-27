package com.mrtoper.batMap

import com.glaurung.batMap.io.AreaDataPersister
import com.glaurung.batMap.io.GsonJsonSerializer
import com.glaurung.batMap.vo.AreaSaveObject
import spock.lang.*

/**
 * IO persister tests
 */
class PersisterTest extends Specification {
	String baseDir = "D:\\SRC\\test\\batmapper\\src\\test\\java\\com\\mrtoper\\"

	def "convert batmap to json"(){
			String areaName = "dunamor"
			AreaSaveObject areaSaveObject = AreaDataPersister.loadData(baseDir, areaName)

		when:
			GsonJsonSerializer.save(areaSaveObject)
			GsonJsonSerializer.load(baseDir + File.pathSeparator + areaName +".json")

		then:
			//File f = new File(baseDir, areaName + ".json")
			//assert f.exists()
			notThrown()

	}

	def "convert all batmaps to json"(){
		when:
			AreaDataPersister.convertFilesToJson(baseDir)
		then:
			notThrown()
	}

}