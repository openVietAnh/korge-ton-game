import korlibs.korge.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	alias(libs.plugins.korge)
}

kotlin {
    js(KotlinJsCompilerType.IR) {
        browser {
            binaries.executable()
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }

        this.attributes.attribute(KotlinPlatformType.attribute, KotlinPlatformType.js)

//        compilations.all {
//            it.kotlinOptions.apply {
//                sourceMap = true
//                //metaInfo = true
//                //moduleKind = "umd"
//                suppressWarnings = korge.supressWarnings
//            }
//        }
    }

    sourceSets.maybeCreate("jsTest").apply {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test-js")
            implementation(npm("@tonconnect/ui", "2.0.3"))
        }
    }
}

korge {
	id = "com.sample.demo"
	targetJs()
	serializationJson()
}


dependencies {
    add("commonMainApi", project(":deps"))
}
