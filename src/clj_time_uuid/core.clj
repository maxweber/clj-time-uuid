(ns clj-time-uuid.core)

(defn- eaio-uuid-to-java-util-uuid
  "Converts a com.eaio.uuid.UUID to a java.util.UUID"
  [eaio-uuid]
  (java.util.UUID. (.getTime eaio-uuid) (.getClockSeqAndNode eaio-uuid)))

(defn uuid
  "Generates a new universally unique identifier (version 1, based on
   time and MAC address) and wraps it up in a java.util.UUID instance
   to ease working with EDN or Fressian serialization."
  []
  (eaio-uuid-to-java-util-uuid (com.eaio.uuid.UUID.)))