#!/bin/bash 
#find files contains a keyword 
#write by xiaojing.zhao 
#2012.12.14 
 
echo -e "\nThis is a script to find all the files in a specified path contains a keyword!" 
 
echo -e "\nPlease input a keyword:" 
read key 
if [ "$key" == "" ]; then 
    echo -e "keyword can not be null!\n" 
    exit 0 
fi 
keyword=$key 
 
echo -e "\nPlease input your specified path:" 
read dir 
#���f勘H�a���ۑ��݁C�󊎐���U_�C�s���ݓ��o�� 
test ! -d $dir && echo -e "The $dir is not exist in your system.\n\n" && exit 0 
 
echo -e "\n---------------You find files are:---------------\n" 
 
#keyword=JAVA_OPTS 
#dir=/jboss/jboss-eap-4.3/jboss-as/ 
 
#�~���������� 
file_count=0 
#�R_�g�ŏ��L��U_�C���Ő[�H�a�C�s>f����s 
file_list=`ls -R $dir 2> /dev/null | grep -v '^$'` 
for file_name in $file_list 
do 
    #4N�e�����S��temp�C��ls -R��file_list���I�����������L�C�z:�@�ڈ꘢�������C�ӎ����i.��\�C�ӎ����C*��\0��������$��\�s���~�����j�S�Ǒ�bc:N�� 
    #�{US�I�C�A���cfile_name�S�ʒ��I�C�z�F�I�s�C���F�@���e��bc:N�� 
    temp=`echo $file_name | sed 's/:.*$//g'` 
    #�@��4N�e�����S��temp���꘢��U_�C���񕶌��C�A��勖�U_K�<P�~cur_dir�S�� 
    if [ "$file_name" != "$temp" ]; then 
        cur_dir=$temp 
        #echo "-"$cur_dir #4N�e>f���C�Ջ�p 
    else 
        #�pfile�����g�ŕ����^�g����:NASCII text{|�^ 
        file_type=`file $cur_dir/$file_name | grep "text"` 
        if [ "$file_type" != "" ]; then 
            temp=`grep $keyword $cur_dir/$file_name 2> /dev/null` 
            #echo "--"$cur_dir/$file_name #4N�e>f���C�Ջ�p 
            if [ "$temp" != "" ]; then 
                echo $cur_dir/$file_name 
                #����������1 
                let file_count++ 
            fi 
        fi 
    fi 
done 
 
echo -e "\n-------------------------------------------------" 
echo -e "\n\nFiles Total: $file_count" 
echo -e "\nFind Finished!\n" 