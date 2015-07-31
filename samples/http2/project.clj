(defproject hp "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [io.pedestal/pedestal.service "0.4.1-SNAPSHOT"]

                 ;; Remove this line and uncomment one of the next lines to
                 ;; use Immutant or Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.4.1-SNAPSHOT"]
                 ;; [io.pedestal/pedestal.immutant "0.4.1-SNAPSHOT"]
                 ;; [io.pedestal/pedestal.tomcat "0.4.1-SNAPSHOT"]

                 [ch.qos.logback/logback-classic "1.1.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.12"]
                 [org.slf4j/jcl-over-slf4j "1.7.12"]
                 [org.slf4j/log4j-over-slf4j "1.7.12"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :plugins      [[codox "0.8.13"]
                 [info.sunng/lein-bootclasspath-deps "0.2.0"]]
  :boot-dependencies [[org.mortbay.jetty.alpn/alpn-boot "8.1.4.v20150727"]]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "hp.server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.4.1-SNAPSHOT"]]}
             :uberjar {:aot [hp.server]}}
  :main ^{:skip-aot true} hp.server)

