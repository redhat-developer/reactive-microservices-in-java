# Vert.x Cluster Configuration

By default, the Vert.x cluster manager based on Infinispan uses _multicast_. If your network does not support 
_multicast_, you can configure Infinispan to use another discovery protocol such as _unicast_.

Infinispan is based on _JGroups_, and to configure the discovery, you must provide a `jgroups.xml` file in the 
application `CLASSPATH`.

The `jgroups.xml` file available in this directory is configured to use _unicast_ on 127.0.0.1. You will only 
discover applications running on the same machine. To use this configuration, just copy the file to the 
`src/main/resources` directory of your source code.                                                                    
        
        
