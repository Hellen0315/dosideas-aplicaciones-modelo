PATH=/usr/bin:/etc:/usr/sbin:/usr/ucb:$HOME/bin:/usr/bin/X11:/sbin:/usr/local/bin/:.

export PATH

if [ -s "$MAIL" ]           # This is at Shell startup.  In normal
then echo "$MAILMSG"        # operation, the Shell checks
fi                          # periodically.

PS1='$IFS$ $LOGNAME:$PWD$IFS> '; export PS1

export JAVA_HOME=/usr/java6_64
export ORACLE_HOME=/oracle/product/10.2.0
export ORA_NLS33=/oracle/product/10.2.0/nls/data
export LD_LIBRARY_PATH=$ORACLE_HOME/lib32

PATH=$PATH:$ORACLE_HOME/bin:$JAVA_HOME/bin

export PROP=/domains/Apl_Web/servers/miAutogestion_2/properties
export LOG=/logs/Apl_Web/miAutogestion_2
export SITE=/internet/sites/desa-PNT/public_8843/autogestion

export APACHE_HOME=/usr/local/apache2
export SSO_APACHE=/internet/apache/weblogic
export SSO_LOG=/logs/Apl_Web/miAutogestion_1
